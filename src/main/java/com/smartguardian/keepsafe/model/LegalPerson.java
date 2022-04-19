package com.smartguardian.keepsafe.model;

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
import java.util.Objects;

import java.util.List;

@Entity
@Table(name = "tbl_pessoa_juridica")
public class LegalPerson extends User {
    private static final long serialVersionUID = 1L;

    @Column(name = "nr_cnpj_pessoa_juridica", nullable = false, length = 14)
    private String document;

    @OneToMany(mappedBy = "legalPerson")
    private List<IssueType> issueTypeList;

    public LegalPerson() {
    }

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
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LegalPerson)) {
            return false;
        }
        LegalPerson legalPerson = (LegalPerson) o;
        return Objects.equals(document, legalPerson.document)
                && Objects.equals(issueTypeList, legalPerson.issueTypeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(document, issueTypeList);
    }

    @Override
    public String toString() {
        return "LegalPerson [document=" + document + ", issueTypeList="
                + issueTypeList + "]";
    }

}
