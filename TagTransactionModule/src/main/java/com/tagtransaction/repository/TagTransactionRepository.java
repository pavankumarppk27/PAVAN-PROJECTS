package com.tagtransaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tagtransaction.entity.TagTransactionEntity;

@Repository
public interface TagTransactionRepository extends JpaRepository<TagTransactionEntity, Long> {

}
