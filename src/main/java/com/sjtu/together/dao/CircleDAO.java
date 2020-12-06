package com.sjtu.together.dao;

import com.sjtu.together.entity.Circle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CircleDAO extends JpaRepository<Circle, Integer> {

    Circle getCircleByCircleID(int circleID);
}
