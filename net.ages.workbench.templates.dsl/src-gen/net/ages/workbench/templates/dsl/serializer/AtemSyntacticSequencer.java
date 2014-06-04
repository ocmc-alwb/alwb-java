package net.ages.workbench.templates.dsl.serializer;

import com.google.inject.Inject;
import java.util.List;
import net.ages.workbench.templates.dsl.services.AtemGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class AtemSyntacticSequencer extends AbstractSyntacticSequencer {

	protected AtemGrammarAccess grammarAccess;
	protected AbstractElementAlias match_WhenPascha_OtherwiseUseKeyword_2_0_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (AtemGrammarAccess) access;
		match_WhenPascha_OtherwiseUseKeyword_2_0_q = new TokenAlias(false, true, grammarAccess.getWhenPaschaAccess().getOtherwiseUseKeyword_2_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_WhenPascha_OtherwiseUseKeyword_2_0_q.equals(syntax))
				emit_WhenPascha_OtherwiseUseKeyword_2_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     'otherwise use:'?
	 */
	protected void emit_WhenPascha_OtherwiseUseKeyword_2_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
