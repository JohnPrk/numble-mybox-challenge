package com.numble.mybox.acceptanceTest;

import com.numble.mybox.member.service.dto.MemberRequest;
import com.numble.mybox.utils.DatabaseCleanup;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AcceptanceSetUp {

    protected final MemberRequest 사용자1 = new MemberRequest("사용자1");

    @Autowired
    private DatabaseCleanup databaseCleanup;

    @BeforeEach
    public void setUp() {
        databaseCleanup.execute();
    }
}
