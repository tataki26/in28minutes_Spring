package com.in28minutes.learnspringframework.examples.c1.data;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

// @Component
// 구현체가 두 개이므로 우선권을 부여해야 한다
// 그렇지 않으면, no unique 관련 예외가 발생한다
@Primary
// 데이터베이스와 상호 작용(통신)하는 컴포넌트
@Repository
public class MongoDbDataService implements DataService {
    @Override
    public int[] retrieveData() {
        return new int[] {11, 22, 33, 44, 55};
    }
}
