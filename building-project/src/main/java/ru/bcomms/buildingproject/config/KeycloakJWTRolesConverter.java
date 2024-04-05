package ru.bcomms.buildingproject.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class KeycloakJWTRolesConverter implements Converter<Jwt, Collection<GrantedAuthority>> {
    // Префикс будет использован для выделения роле уровня realm
    public static final String PREFIX_REALM_ROLE = "ROLE_realm_";
    // Префикс будет использован для выделения роле уровня клиента
    public static final String PREFIX_RESOURCE_ROLE = "ROLE_";
    // Имя claim содержащего роли уровня realm
    private static final String CLAIM_REALM_ACCESS = "realm_access";
    // Имя claim содержащего роли уровня клиента
    private static final String CLAIM_RESOURCE_ACCESS = "resource_access";
    // Имя claim содержащего роли применимые к уровню realm и клиента
    private static final String CLAIM_ROLES = "roles";
    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        // Роли уровня realm
        // выделяем роли уровня realm
        Map<String, Collection<String>> realmAccess = jwt.getClaim(CLAIM_REALM_ACCESS);
        if (realmAccess != null && !realmAccess.isEmpty()) {
            Collection<String> roles = realmAccess.get(CLAIM_ROLES);
            if (roles != null && !roles.isEmpty()) {
                Collection<GrantedAuthority> realmRoles = roles.stream()
                        .map(role -> new SimpleGrantedAuthority(PREFIX_REALM_ROLE + role))
                        .collect(Collectors.toList());
                grantedAuthorities.addAll(realmRoles);
            }
        }
        // Роли уровня клиента
        // выделяем роли уровня клиента
        Map<String, Map<String, Collection<String>>> resourceAccess = jwt.getClaim(CLAIM_RESOURCE_ACCESS);
        if (resourceAccess != null && !resourceAccess.isEmpty()) {
            resourceAccess.forEach((resource, resourceClaims) -> {
                resourceClaims.get(CLAIM_ROLES).forEach(
                        role -> grantedAuthorities
                                .add(new SimpleGrantedAuthority(PREFIX_RESOURCE_ROLE +
                                        resource + "_" + role))
                );
            });
        }
        return grantedAuthorities;
    }
}
