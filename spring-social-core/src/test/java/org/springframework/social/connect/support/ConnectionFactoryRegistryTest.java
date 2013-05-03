/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.connect.support;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.oauth1.OAuth1Operations;
import org.springframework.social.oauth1.OAuth1ServiceProvider;

public class ConnectionFactoryRegistryTest {

	private ConnectionFactoryRegistry connectionFactoryLocator = new ConnectionFactoryRegistry();

	private TestTwitterConnectionFactory twitterConnectionFactory = new TestTwitterConnectionFactory();
	
	@Before
	public void setUp() {
		connectionFactoryLocator.addConnectionFactory(twitterConnectionFactory);
	}
	
	@Test
	public void getConnectionFactoryByProviderId() {
		ConnectionFactory<?> connectionFactory = connectionFactoryLocator.getConnectionFactory("twitter");
		assertSame(twitterConnectionFactory, connectionFactory);
		assertEquals("twitter", connectionFactory.getProviderId());
	}
	
	@Test
	public void getConnectionFactoryByApi() {
		ConnectionFactory<TestTwitterApi> connectionFactory = connectionFactoryLocator.getConnectionFactory(TestTwitterApi.class);
		assertSame(twitterConnectionFactory, connectionFactory);
		assertEquals("twitter", connectionFactory.getProviderId());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void addDuplicateProviderId() {
		connectionFactoryLocator.addConnectionFactory(new TestTwitterConnectionFactory());
	}

	@Test(expected=IllegalArgumentException.class)
	public void addDuplicateApiType() {
		connectionFactoryLocator.addConnectionFactory(new TestTwitter2ConnectionFactory());
	}
	
	static class TestTwitterConnectionFactory extends OAuth1ConnectionFactory<TestTwitterApi> {

		public TestTwitterConnectionFactory() {
			super("twitter", new TestTwitterServiceProvider(), null);
		}
		
	}

	static class TestTwitter2ConnectionFactory extends OAuth1ConnectionFactory<TestTwitterApi> {

		public TestTwitter2ConnectionFactory() {
			super("twitter2", new TestTwitterServiceProvider(), null);
		}
		
	}
	
	static class TestTwitterServiceProvider implements OAuth1ServiceProvider<TestTwitterApi> {

		public OAuth1Operations getOAuthOperations() {
			return null;
		}

		public TestTwitterApi getApi(String accessToken, String secret) {
			return null;
		}
		
	}
		
	interface TestTwitterApi {
		
	}
}
