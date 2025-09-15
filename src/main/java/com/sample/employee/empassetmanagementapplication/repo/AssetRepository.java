package com.sample.employee.empassetmanagementapplication.repo;

import com.sample.employee.empassetmanagementapplication.entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  AssetRepository extends JpaRepository<Asset, Long> {
}
