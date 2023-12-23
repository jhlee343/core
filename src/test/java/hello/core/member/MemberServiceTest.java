package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberSerivce memberSerivce = new MemberServiceImpl();
    @Test
    void join(){
        Member member = new Member(1L,"memberA",Grade.VIP);
        memberSerivce.join(member);
        Member findMember = memberSerivce.findMember(1L);
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
