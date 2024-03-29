package your.tmi.security.auth;

/*
* 시큐리티가 /login을 주소 요청을 낚아서 로그인 진행
* 로그인 진행이 완료가 되면 시큐리티가 가진 session을 만든다. (Security ContextHolder)
* Authentication 타입의 객체만 가능
* Authentication 내부에 Member 정보가 있어햐 한다.
* */

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import your.tmi.entity.Member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Getter
public class PrincipalDetails implements UserDetails, OAuth2User {

    private Member member; // 컴포지션
    private Map<String, Object> attributes;

    public PrincipalDetails(Member member) {
        this.member = member;
    }

    public PrincipalDetails(Member member, Map<String, Object> attributes) {
        this.member = member;
        this.attributes = attributes;
    }

    // 해당 Member의 권한 반환
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();

/*
        collect.add((GrantedAuthority) () -> {
//            return basicUser.getUserRole().getKey(); // ROLE_ 생략시 권한 인식을 못함
            return "ROLE_" + basicUser.getUserRole();
        });
*/

        return collect;
    }


    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        return member.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return member.getId();
    }

    @Override
    public String getName() {
        return null;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }
}
