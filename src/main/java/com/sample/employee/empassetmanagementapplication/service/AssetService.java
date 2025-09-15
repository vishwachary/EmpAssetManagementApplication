package com.sample.employee.empassetmanagementapplication.service;

import com.sample.employee.empassetmanagementapplication.entity.Asset;
import com.sample.employee.empassetmanagementapplication.entity.AssetStatus;
import java.util.List;

public interface AssetService {
    Asset assignAsset(Long empId, Asset asset);
    List<Asset> getAssetsByEmployee(Long empId);
    Asset updateAssetStatus(Long assetId, AssetStatus status);
    void deleteAsset(Long assetId);
}
