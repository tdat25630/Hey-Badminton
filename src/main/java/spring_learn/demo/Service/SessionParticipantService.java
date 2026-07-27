package spring_learn.demo.Service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import spring_learn.demo.DAL.DAOImpl.SessionDAOImpl;
import spring_learn.demo.DAL.DAOImpl.SessionParticipantDAOImpl;
import spring_learn.demo.DAL.DAOImpl.UserDAOJpaImpl;
import spring_learn.demo.dto.request.SessionParticipantRequest;
import spring_learn.demo.dto.response.PageResponse;
import spring_learn.demo.dto.response.SessionParticipantResponse;
import spring_learn.demo.entity.BSession;
import spring_learn.demo.entity.SessionParticipant;
import spring_learn.demo.entity.User;
import spring_learn.demo.mapper.ISessionParticipantMapper;
import spring_learn.demo.mapper.PageMapper;

@RequiredArgsConstructor
@Service
@Slf4j
public class SessionParticipantService {

    private final SessionParticipantDAOImpl sessionParticipantDAO;
    private final ISessionParticipantMapper sessionParticipantMapper;
    private final PageMapper pageMapper;
    private final SessionDAOImpl sessionDAO;
    private final UserDAOJpaImpl userDAO;


    public SessionParticipantResponse createSessionParticipant(SessionParticipantRequest request){

        SessionParticipant sessionParticipant = sessionParticipantMapper.toSessionParticipant(request);

        BSession session = sessionDAO.findById(request.getSessionId()).orElseThrow(()-> new RuntimeException("session not existed"));


        User user = userDAO.findById(request.getUserId()).orElseThrow(()-> new RuntimeException("user not exist"));

        sessionParticipant.setSessionId(session);
        sessionParticipant.setUser(user);

        return sessionParticipantMapper.toSessionParticipantResponse(sessionParticipantDAO.save(sessionParticipant));
    }

    public SessionParticipantResponse addGuessToSession(SessionParticipantRequest request){

        SessionParticipant sessionParticipant = sessionParticipantMapper.toSessionParticipant(request);

        BSession session = sessionDAO.findById(request.getSessionId()).orElseThrow(()-> new RuntimeException("session not existed"));



        sessionParticipant.setSessionId(session);

        return sessionParticipantMapper.toSessionParticipantResponse(sessionParticipantDAO.save(sessionParticipant));
    }



    public PageResponse<SessionParticipantResponse> getAllSessionParticipantsBySessionId(String sessionId, Pageable pageable){

        Page<SessionParticipant> page = sessionParticipantDAO.findBySessionId(sessionId,pageable);

        return pageMapper.toPageResponse(page, sessionParticipantMapper::toSessionParticipantResponse);
    }


}
