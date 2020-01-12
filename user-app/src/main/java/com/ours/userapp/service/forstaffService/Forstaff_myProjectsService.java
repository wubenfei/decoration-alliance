package com.ours.userapp.service.forstaffService;

import java.util.List;
import java.util.Map;

public interface Forstaff_myProjectsService {
    List<Map<String, Object>> getStepList(Integer des_id);

    Map<String, Object> getStep(Integer contractid);
}
