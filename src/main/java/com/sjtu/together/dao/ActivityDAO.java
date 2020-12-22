package com.sjtu.together.dao;

import com.sjtu.together.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityDAO extends JpaRepository<Activity, Integer> {
    Activity findActivityByActivityID(int actid);

    List<Activity> findByActivityPlaceLike(String activityPlace);
}
