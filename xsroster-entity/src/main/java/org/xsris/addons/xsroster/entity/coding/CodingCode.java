package org.xsris.addons.xsroster.entity.coding;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.xsris.addons.xsroster.entity.base.IdentifiableEntity;

@Entity
@Table(name = "CODING_CODE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "CATEGORY", discriminatorType = DiscriminatorType.STRING, length = 50)
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CodingCode extends IdentifiableEntity {

	private static final long serialVersionUID = 6977101067006751142L;

}
