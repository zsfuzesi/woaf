package woaf.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the state_transition database table.
 * 
 */
@Entity
@Table(name="state_transition")
@NamedQueries({ 
	@NamedQuery(name = "StateTransition.findAll", query = "SELECT s FROM StateTransition s"), 
	@NamedQuery(name = "StateStransition.findAllByStateFrom", query = "   SELECT sTransition  FROM StateTransition sTransition JOIN sTransition.stateTo stateTo  WHERE stateTo.stateMachine.subject.subjectId = :subjectid  AND sTransition.stateFrom.stateId = :stateFrom"),
	@NamedQuery(name = "StateStransition.findAllStartStateTransition", query = "   SELECT sTransition  FROM StateTransition sTransition JOIN sTransition.stateTo stateTo  WHERE stateTo.stateMachine.subject.subjectId = :subjectid  AND sTransition.stateFrom is null")
})
public class StateTransition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="transition_id")
	private int transitionId;

	private String name;

	//bi-directional many-to-one association to State
	@ManyToOne
	@JoinColumn(name="state_from")
	private State stateFrom;

	//bi-directional many-to-one association to State
	@ManyToOne
	@JoinColumn(name="state_to")
	private State stateTo;

	public StateTransition() {
	}

	public int getTransitionId() {
		return this.transitionId;
	}

	public void setTransitionId(int transitionId) {
		this.transitionId = transitionId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getStateFrom() {
		return this.stateFrom;
	}

	public void setStateFrom(State stateFrom) {
		this.stateFrom = stateFrom;
	}

	public State getStateTo() {
		return this.stateTo;
	}

	public void setStateTo(State stateTo) {
		this.stateTo = stateTo;
	}

}