package com.keyrus.dockerspring.dao;

import com.keyrus.dockerspring.form.DevForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevDao extends JpaRepository<DevForm, Long> {


}
