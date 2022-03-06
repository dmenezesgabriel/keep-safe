package com.smartguardian.domain.entity;

/**
 * Legal Person entity
 *
 * @author Smart Guardian Group
 * @version 1.0
 */


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;


@Entity
@Table(name = "tbl_pessoa_juridica")
public class LegalPerson extends User {
    private static final long serialVersionUID = 1L;

    @Column(name = "nr_cnpj_pessoa_juridica", nullable = false, length = 14)
    private String document;
    
    @OneToMany(mappedBy = "legalPerson")
    private List<IssueType> issueTypeList;

    public LegalPerson() {}

    public LegalPerson(String document, List<IssueType> issueTypeList) {
		super();
		this.document = document;
		this.issueTypeList = issueTypeList;
	}

	public String getDocument() {
        return this.document;
    }

    public void setDocument(String document) {
        this.document = document;
    }


    public List<IssueType> getIssueTypeList() {
		return issueTypeList;
	}

	public void setIssueTypeList(List<IssueType> issueTypeList) {
		this.issueTypeList = issueTypeList;
	}

	public LegalPerson document(String document) {
        setDocument(document);
        return this;
    }
	
	public LegalPerson issueType(IssueType issueType) {
		this.issueTypeList.add(issueType);
		return this;
	}
	
	public LegalPerson issueTypeList(List<IssueType> issueTypeList) {
		setIssueTypeList(issueTypeList);
		return this;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((document == null) ? 0 : document.hashCode());
		result = prime * result + ((issueTypeList == null) ? 0 : issueTypeList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		LegalPerson other = (LegalPerson) obj;
		if (document == null) {
			if (other.document != null)
				return false;
		} else if (!document.equals(other.document))
			return false;
		if (issueTypeList == null) {
			if (other.issueTypeList != null)
				return false;
		} else if (!issueTypeList.equals(other.issueTypeList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LegalPerson [document=" + document + ", issueTypeList=" + issueTypeList + "]";
	}

}
