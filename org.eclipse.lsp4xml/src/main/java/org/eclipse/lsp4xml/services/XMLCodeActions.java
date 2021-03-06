package org.eclipse.lsp4xml.services;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.lsp4j.CodeAction;
import org.eclipse.lsp4j.CodeActionContext;
import org.eclipse.lsp4j.Command;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4xml.model.XMLDocument;
import org.eclipse.lsp4xml.services.extensions.ICodeActionParticipant;
import org.eclipse.lsp4xml.services.extensions.XMLExtensionsRegistry;

public class XMLCodeActions {

	private final XMLExtensionsRegistry extensionsRegistry;

	public XMLCodeActions(XMLExtensionsRegistry extensionsRegistry) {
		this.extensionsRegistry = extensionsRegistry;
	}

	public List<CodeAction> doCodeActions(CodeActionContext context, Range range, XMLDocument document) {
		List<CodeAction> codeActions = new ArrayList<>();
		for (Diagnostic diagnostic : context.getDiagnostics()) {
			for (ICodeActionParticipant codeActionParticipant : extensionsRegistry.getCodeActionsParticipants()) {
				codeActionParticipant.doCodeAction(diagnostic, range, document, codeActions);
			}
		}
		return codeActions;
	}
}
