package spring_learn.demo.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import spring_learn.demo.DAL.DAOImpl.SessionDAOImpl;
import spring_learn.demo.dto.request.SessionCreationRequest;
import spring_learn.demo.dto.response.PageResponse;
import spring_learn.demo.dto.response.SessionResponse;
import spring_learn.demo.entity.BSession;
import spring_learn.demo.mapper.ISessionMapper;
import spring_learn.demo.mapper.PageMapper;

@Service
@RequiredArgsConstructor
@Slf4j
public class BSessionService {

    private final SessionDAOImpl sessionDAOImpl;
    private final ISessionMapper iSessionMapper;
    private final PageMapper pageMapper;


    public SessionResponse createSession (SessionCreationRequest request){

        BSession bSession = iSessionMapper.toSession(request);


        return iSessionMapper.toSessionResponse(sessionDAOImpl.save(bSession));
    }

    public PageResponse<SessionResponse> getSessions(Pageable pageable){

        Page<BSession> page = sessionDAOImpl.findAll(pageable);

        return pageMapper.toPageResponse(page, iSessionMapper::toSessionResponse);
    }

    public void deleteSession(String sessionId) {

        sessionDAOImpl.deleteById(sessionId);
    }
}
