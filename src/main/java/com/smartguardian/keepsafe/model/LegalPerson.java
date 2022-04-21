package com.smartguardian.keepsafe.model;

/**
 * Legal Person entity
 *
 * @author Smart Guardian Group
 * @version 1.0
 */
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "tbl_pessoa_juridica")
public class LegalPerson extends User {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Document is required!")
    @NotNull(message = "Document may not be null!")
    @NotEmpty(message = "Document may not be empty!")
    @Column(name = "nr_cnpj_pessoa_juridica", nullable = false, length = 14,
            unique = true)
    private String document;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cd_usuario", referencedColumnName = "cd_usuario")
    private List<IssueType> issueTypeList;


    public LegalPerson() {}

    public LegalPerson(String document, List<IssueType> issueTypeList) {
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
        return this.issueTypeList;
    }

    public void setIssueTypeList(List<IssueType> issueTypeList) {
        this.issueTypeList = issueTypeList;
    }

    public LegalPerson document(String document) {
        setDocument(document);
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
        return "{" + " document='" + getDocument() + "'" + ", issueTypeList='"
                + getIssueTypeList() + "'" + "}";
    }


}
