package ru.bcomms.incomingmaterialcontroljournal.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class KeycloakJWTRolesConverter implements Converter<Jwt, Collection<GrantedAuthority>> {
    // Prefix used for realm level roles.
    public static final String PREFIX_REALM_ROLE = "ROLE_realm_";
    // Prefix used in combination with the resource (client) name for resource level roles.
    public static final String PREFIX_RESOURCE_ROLE = "ROLE_";
    // Name of the claim containing the realm level roles
    private static final String CLAIM_REALM_ACCESS = "realm_access";
    // Name of the claim containing the resources (clients) the user has access to.
    private static final String CLAIM_RESOURCE_ACCESS = "resource_access";
    // Name of the claim containing roles. (Applicable to realm and resource level.)
    private static final String CLAIM_ROLES = "roles";
    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        // Realm roles
        // Get the part of the access token that holds the roles assigned on realm level
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
        // Resource (client) roles
        // A user might have access to multiple resources all containing their own roles.
        // Therefore, it is a map of resource each possibly containing a "roles" property
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
