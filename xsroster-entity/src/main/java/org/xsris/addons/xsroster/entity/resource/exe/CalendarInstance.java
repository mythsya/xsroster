package org.xsris.addons.xsroster.entity.resource.exe;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.xsris.addons.xsroster.entity.base.IdentifiableEntity;
import org.xsris.addons.xsroster.entity.resource.def.CalendarDefinition;

@Entity
@Table(name = "CALENDAR_INSTANCE")
public class CalendarInstance extends IdentifiableEntity {

	private static final long serialVersionUID = -7819655184710075641L;

	private CalendarDefinition calendarDefinition;

	@ManyToOne
	@JoinColumn(name = "CALENDAR_DEFINITION")
	public CalendarDefinition getCalendarDefinition() {
		return calendarDefinition;
	}

	public void setCalendarDefinition(CalendarDefinition calendarDefinition) {
		this.calendarDefinition = calendarDefinition;
	}

}
