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
package org.springframework.social.oauth2;

/**
 * OAuth2 supports two types of authorization flow, typically referred to as
 * "Client-side" and "Server-side".
 * @author Roy Clarkson
 * @deprecated Use of implicit grant doesn't make sense in any of the contexts where Spring Social is supported (web server or mobile Android client).
 *             Therefore, the GrantType enum and methods that accept it do not make sense.
 */
@Deprecated
public enum GrantType {
	
	/**
	 * AUTHORIZATION_CODE denotes the server-side authorization flow, and is
	 * associated with the response_type=code parameter value
	 */
	AUTHORIZATION_CODE,

	/**
	 * IMPLICIT_GRANT denotes the client-side authorization flow and is
	 * associated with the response_type=token parameter value
	 */
	IMPLICIT_GRANT
}
