package spring_learn.demo.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import spring_learn.demo.dto.request.SessionCreationRequest;
import spring_learn.demo.dto.response.SessionResponse;
import spring_learn.demo.entity.BSession;

@Mapper(componentModel = "spring")
public interface ISessionMapper {
    @Mapping(target = "participants", ignore = true)
    BSession toSession(SessionCreationRequest sessionCreationRequest);
    @Mapping(target = "sessionId", source = "id")
    SessionResponse toSessionResponse(BSession session);

}
