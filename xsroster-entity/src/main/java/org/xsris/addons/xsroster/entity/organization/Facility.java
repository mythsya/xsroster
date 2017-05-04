package org.xsris.addons.xsroster.entity.organization;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.agfa.sh.eqis.core.entities.namecode.FacilityType;

@Entity
@Table(name = "FACILITY")
@DiscriminatorValue(value = "A")
public class Facility extends Company {
	private static final long serialVersionUID = 3435731754719356280L;

	private Boolean external;
	private FacilityType facilityType;

	@Column(name = "IS_EXTERNAL", nullable = false)
	public Boolean getExternal() {
		return this.external;
	}

	@ManyToOne
	@JoinColumn(name = "FACILITY_TYPE", nullable = false)
	public FacilityType getFacilityType() {
		return this.facilityType;
	}

	public void setExternal(Boolean external) {
		this.external = external;
	}

	public void setFacilityType(FacilityType facilityType) {
		this.facilityType = facilityType;
	}
}
