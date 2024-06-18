package com.loginauthsystem.security.util;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Version;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class BaseEntity implements Serializable {
    public UUID uuid = UUID.randomUUID();

    @CreationTimestamp
    public Instant createdOn;

    @Version
    private long version;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
