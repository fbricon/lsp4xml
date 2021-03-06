/**
 *  Copyright (c) 2018 Angelo ZERR
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *  Angelo Zerr <angelo.zerr@gmail.com> - initial API and implementation
 */
package org.eclipse.lsp4xml.services;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionList;
import org.eclipse.lsp4xml.services.extensions.ICompletionResponse;

/**
 * Completion response implementation.
 *
 */
class CompletionResponse extends CompletionList implements ICompletionResponse {

	private List<String> seenAttributes;

	public CompletionResponse() {
		super.setIsIncomplete(false);
	}

	@Override
	public void addCompletionItem(CompletionItem completionItem) {
		super.getItems().add(completionItem);
	}

	@Override
	public boolean hasAttribute(String attribute) {
		/*
		 * if (node != null && node.hasAttribute(attribute)) { return true; }
		 */
		return seenAttributes != null ? seenAttributes.contains(attribute) : false;
	}

	@Override
	public void addCompletionAttribute(CompletionItem completionItem) {
		if (seenAttributes == null) {
			seenAttributes = new ArrayList<>();
		}
		seenAttributes.add(completionItem.getLabel());
		addCompletionItem(completionItem);
	}

}
