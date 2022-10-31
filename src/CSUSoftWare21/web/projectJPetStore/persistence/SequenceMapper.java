package CSUSoftWare21.web.projectJPetStore.persistence;

import CSUSoftWare21.web.projectJPetStore.domain.Sequence;

public interface SequenceMapper {
    Sequence getSequence(Sequence sequence);
    void updateSequence(Sequence sequence);
}
