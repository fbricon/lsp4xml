/*******************************************************************************
 * Copyright (c) 2018 Red Hat Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat Inc. - initial API and implementation
 *
 *******************************************************************************/
package org.eclipse.lsp4xml.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

/**
 * JSONUtility
 */
public class JSONUtility {

  public static <T> T toModel(Object object, Class<T> clazz){
		if(object == null){
			return null;
		}
		if(clazz == null ){
			throw new IllegalArgumentException("Class can not be null");
		}
		if(object instanceof JsonElement){
			Gson gson = new Gson();
			return gson.fromJson((JsonElement) object, clazz);
		}
		if(clazz.isInstance(object)){
			return clazz.cast(object);
		}
		return null;
  }
}