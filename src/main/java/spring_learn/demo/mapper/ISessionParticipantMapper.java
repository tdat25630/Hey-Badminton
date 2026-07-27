package spring_learn.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import spring_learn.demo.dto.request.SessionParticipantRequest;
import spring_learn.demo.dto.response.SessionParticipantResponse;
import spring_learn.demo.entity.SessionParticipant;

@Mapper(componentModel = "spring")
public interface ISessionParticipantMapper {
    @Mapping(target = "sessionId", ignore = true)
    SessionParticipant toSessionParticipant(SessionParticipantRequest sessionParticipantRequest);
    @Mapping(target = "sessionId", source = "id")
    @Mapping(source = "user.id", target = "userId")
    SessionParticipantResponse toSessionParticipantResponse(SessionParticipant sessionParticipant);
}
