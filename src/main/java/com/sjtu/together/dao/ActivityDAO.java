package com.sjtu.together.dao;

import com.sjtu.together.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityDAO extends JpaRepository<Activity, Integer> {
    Activity findActivityByActivityID(int actid);
}
