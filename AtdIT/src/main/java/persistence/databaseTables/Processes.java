package main.java.persistence.databaseTables;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "Processes")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "Type")
public class Processes extends AbstractEntry {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int		ProcessID;
	private String	Type;
}
