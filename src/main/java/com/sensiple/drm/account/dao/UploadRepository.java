package com.sensiple.drm.account.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sensiple.drm.account.entity.Upload;

@Repository
public interface UploadRepository extends JpaRepository<Upload, String> {

}
