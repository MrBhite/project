package CSUSoftWare21.web.projectJPetStore.persistence.Dao;

import CSUSoftWare21.web.projectJPetStore.domain.Sequence;

public interface SequenceDao {

    Sequence getSequence(Sequence sequence);

    void updateSequence(Sequence sequence);

}
