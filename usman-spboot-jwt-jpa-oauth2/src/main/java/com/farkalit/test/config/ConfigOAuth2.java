package com.farkalit.test.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class ConfigOAuth2 extends AuthorizationServerConfigurerAdapter {

	private static final Logger LOG = LogManager.getLogger(ConfigOAuth2.class);
	
	private String clientId = "usmanjpa";
	private String clientSecret = "usmanjpa@secret!key";
	
	
	private String privateKey = "-----BEGIN RSA PRIVATE KEY-----\n"
			+ "MIIEpAIBAAKCAQEAqsxcIUXDs6QYRVQhBfiWN4IJtXPH4Ubp7lM1gPKHDCYBZWnY\n"
			+ "0R9ijL5K3RWap6hQsnppXZUSl8gmgG3A5frAdJKEiUjaLTvawnCjNP1f3c0Wts/m\n"
			+ "c5dWghhRmC8zh0k6eJxcT1KPnlUT+JgARjc0jV8m12NrZJUsyODmGVq3U7OctjUI\n"
			+ "p1E1uKePyeTVIY8iofig7aG4mk0FtjHpoUJIu32bIdhCHER5hGXa1R0Xxpx2SnYS\n"
			+ "4N8DsDwgMvPeG/mW6t4QxXr/49N0pFXT9ifCgC3NnKGjNCxS1lkilNT3Sj3wfHs4\n"
			+ "FFRwf5XiUJ434pqGTvDYHoB5lGxTruMtbzwYZQIDAQABAoIBAAXBx6Uzdco7ULod\n"
			+ "gNNzspSCZJNiKK2WN1JaKaaEBjtJmKhzbeR2m1rFGz7ieIkIKlgpuh12Zd8J1wpj\n"
			+ "KKpXzl7fhWofM4Nszg3ZwBaMJ8wRGp/k2A6zXi4aZb2scZ8wv7DLDG18Ce07TuYF\n"
			+ "MZUsTTAqseN2rWsBgDXxJrBaF23RxPDNbdRGrDm2qBK7ERpPHSV97N39N12u6Y7t\n"
			+ "tzUq54mayz5oIZdDSxmyHzjkScPW4fxgHrbhPbaSkX53YkWDN+Cbb9K4NUbQZoI+\n"
			+ "F0EW/BF7PS8qFC2BsICzUyw3t6oxW9EihBpv3peeGh4AF5Oxhy3eVn1qttcJKn+p\n"
			+ "SC5NKcECgYEA0YGCiwNM47D8UXpfljJzWbqW+rnjcmD9tzEAti1brh0TIc1rzPjq\n"
			+ "QHjeQYFnJiaec631LQqcdjFgCbT+TFvgvc4+vGqU/xxyHSyTXy8LqcjuK/DmVBFQ\n"
			+ "S0VFnH8EJ9DscbXW36bba2FImR1n9sWBw4uZ8RHOoWTj8DP994bIv3UCgYEA0LPJ\n"
			+ "BBtTLt7jtNIcnet9qJ3IhHz5zOYvSw/hVllZXmnDfqMvYlF9aUGf1FAsxTl4hpRh\n"
			+ "BIw2Mx+Q3ipqw5hKSako9NgON5eOJ0yURkj+hsHCRx1F35UkV/LoMh5J0BBR1316\n"
			+ "IlAKOehVMnlNBIc9R9/J0swe3eSq3JrKV64eRzECgYEAjxPIaFF/sDwNhUNyhiu8\n"
			+ "NTpFo8NRfqqYewQ/PSsq4nS+vSYCCgCwUgl5l/jczeQv8EaMGw+VHO7JbLert9BD\n"
			+ "Yry4gYq0aKkvkZcAqk+BwpkTdvTVB/KvCEitqpvf5aU75MhPj3vve5z7rH21o4Tt\n"
			+ "AvOS1VzY5cX2GPQY7HOjI4UCgYEAgPztG12sDsbxY1uNFklqs6E5QjFfzrThu/nH\n"
			+ "oq+8XW7uxcEj0xdcdIZ7uyQGV6sKg9sHD2F9SiGTTsxWiicAmwAy8Qjr2I4R7NYW\n"
			+ "uk35Cd6NLZi5C9PIz5awzfEMW80KWC4UI0rm1x1yMqzn3gmb5WU5/s/rr+bZd1kv\n"
			+ "//r8ebECgYACjWvP+o1RMdiLxetLM6rfdLgKsjT3CErg9qbwCMAltjNddAnNvEET\n"
			+ "Cd25/GIHBM33PkKI7VgpAxzyJ8HL6LsK8MtH3Sm+JY4S4IuK148QXggAQv7OH0SZ\n"
			+ "leNVxnPVxVhAoCLlTHvf2BC8DYsTW4AI9nPKbunB3swtwlFpXXkLVQ==\n"
			+ "-----END RSA PRIVATE KEY-----";
	
	
	private String publicKey = "-----BEGIN PUBLIC KEY-----\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqsxcIUXDs6QYRVQhBfiW\n"
			+ "N4IJtXPH4Ubp7lM1gPKHDCYBZWnY0R9ijL5K3RWap6hQsnppXZUSl8gmgG3A5frA\n"
			+ "dJKEiUjaLTvawnCjNP1f3c0Wts/mc5dWghhRmC8zh0k6eJxcT1KPnlUT+JgARjc0\n"
			+ "jV8m12NrZJUsyODmGVq3U7OctjUIp1E1uKePyeTVIY8iofig7aG4mk0FtjHpoUJI\n"
			+ "u32bIdhCHER5hGXa1R0Xxpx2SnYS4N8DsDwgMvPeG/mW6t4QxXr/49N0pFXT9ifC\n"
			+ "gC3NnKGjNCxS1lkilNT3Sj3wfHs4FFRwf5XiUJ434pqGTvDYHoB5lGxTruMtbzwY\n"
			+ "ZQIDAQAB\n"
			+ "-----END PUBLIC KEY-----";

	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Bean
	public JwtAccessTokenConverter tokenEnhancer() {
		LOG.info("...ConfigOAuth2..tokenEnhancer...");
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey(privateKey);
		converter.setVerifierKey(publicKey);
		return converter;
	}

	@Bean
	public JwtTokenStore tokenStore() {
		LOG.info("...ConfigOAuth2..tokenStore...");
		return new JwtTokenStore(tokenEnhancer());
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		LOG.info("...ConfigOAuth2..configure...endpoints...{}", endpoints);
		endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
				.accessTokenConverter(tokenEnhancer());
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		LOG.info("...ConfigOAuth2..configure...security...{}", security);
		security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		LOG.info("...ConfigOAuth2...configure...client...{}", clients);
		clients.inMemory().withClient(clientId).secret(passwordEncoder.encode(clientSecret)).scopes("read", "write")
				.authorizedGrantTypes("password", "refresh_token").accessTokenValiditySeconds(20000)
				.refreshTokenValiditySeconds(20000);

	}

}
