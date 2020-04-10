package com.dzone;

import com.dzone.model.Metric;
import com.dzone.service.IAnagramMetricPort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryAnagramAdapter extends IAnagramMetricPort, CrudRepository<Metric, Long> {

    Metric save(Metric metric);
}
