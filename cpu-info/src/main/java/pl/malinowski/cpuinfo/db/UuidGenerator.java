package pl.malinowski.cpuinfo.db;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.UUIDGenerator;

import java.io.Serializable;
import java.util.Optional;

/**
 * Generator will be generating UUID only if field is null
 */
public class UuidGenerator extends UUIDGenerator {

    @Override
    public Serializable generate(final SharedSessionContractImplementor session, final Object object) {
        return Optional.ofNullable(
            session.getEntityPersister(null, object)
                .getClassMetadata()
                .getIdentifier(object, session)
        ).orElseGet(
            () -> super.generate(session, object)
        );
    }

}
