package hctest.model.domain;

import java.io.Serializable;
import java.util.Date;

import hctest.model.domain.ProductRejection;

public class ProductRejection implements Serializable {

	/**
	 * Zwiększyć o jeden, gdy następuje zmiana dotycząca trwałych właściwości
	 * obiektu (takich, które nie są Transient). Po zmianie trzeba zadbać o to,
	 * by wszystkie projekty, które maja w zależnościach product-catalog-api
	 * posługiwały się nowszą wersją product-catalog-api.
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String mdmindex;

	private String productId;

	private String rejectionCause;

	private Date sentToMdm;

	private Date addedByProductCatalog;

	private String categoryId;

	private String displayName;

	private String catalogName;

	private ProcessingObjectType processingObjectType;

	public ProductRejection() {
		this(null, null, null, null, null, null);
	}

	@Deprecated
	public ProductRejection(String mdmindex, String productId,
			String rejectionCause, String categoryId, String displayName,
			ProcessingObjectType processingObjectType) {
		this(mdmindex, productId, rejectionCause, categoryId, displayName,
				null, processingObjectType);
	}

	public ProductRejection(String mdmindex, String productId,
			String rejectionCause, String categoryId, String displayName,
			String catalogName, ProcessingObjectType processingObjectType) {
		this.mdmindex = mdmindex;
		this.productId = productId;
		this.rejectionCause = rejectionCause;
		this.catalogName = catalogName;
		this.addedByProductCatalog = new Date();
		this.categoryId = categoryId;
		this.displayName = displayName;
		this.sentToMdm = null;
		this.id = null;
		this.processingObjectType = processingObjectType;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public String getCatalogName() {
		return catalogName;
	}

	public Date getSentToMdm() {
		return sentToMdm;
	}

	public void setSentToMdm(Date sentToMdm) {
		this.sentToMdm = sentToMdm;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getProductId() {
		return productId;
	}

	public Date getAddedByProductCatalog() {
		return addedByProductCatalog;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getMdmindex() {
		return mdmindex;
	}

	public String getRejectionCause() {
		return rejectionCause;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMdmindex(String mdmindex) {
		this.mdmindex = mdmindex;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setRejectionCause(String rejectionCause) {
		this.rejectionCause = rejectionCause;
	}

	public void setAddedByProductCatalog(Date addedByProductCatalog) {
		this.addedByProductCatalog = addedByProductCatalog;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getProcessingObjectType() {
		return processingObjectType != null ? processingObjectType.name() : null;
	}

	public void setProcessingObjectType(String processingObjectType) {
		this.processingObjectType = processingObjectType != null ? ProcessingObjectType.valueOf(processingObjectType) : null;
	}

	@Override
	public String toString() {
		return "ProductRejection [id=" + id + ", mdmindex=" + mdmindex
				+ ", productId=" + productId + ", rejectionCause="
				+ rejectionCause + ", sentToMdm=" + sentToMdm
				+ ", addedByProductCatalog=" + addedByProductCatalog
				+ ", categoryId=" + categoryId + ", displayName=" + displayName
				+ ", catalogName=" + catalogName + ", processingObjectType="
				+ processingObjectType + "]";
	}

	public boolean equalsWithoutDatesAndWithoutId(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductRejection other = (ProductRejection) obj;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		if (catalogName == null) {
			if (other.catalogName != null)
				return false;
		} else if (!catalogName.equals(other.catalogName))
			return false;
		if (displayName == null) {
			if (other.displayName != null)
				return false;
		} else if (!displayName.equals(other.displayName))
			return false;
		if (mdmindex == null) {
			if (other.mdmindex != null)
				return false;
		} else if (!mdmindex.equals(other.mdmindex))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (rejectionCause == null) {
			if (other.rejectionCause != null)
				return false;
		} else if (!rejectionCause.equals(other.rejectionCause))
			return false;
		if (processingObjectType == null) {
			if (other.processingObjectType != null)
				return false;
		} else if (!processingObjectType.equals(other.processingObjectType))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((addedByProductCatalog == null) ? 0 : addedByProductCatalog
						.hashCode());
		result = prime * result
				+ ((catalogName == null) ? 0 : catalogName.hashCode());
		result = prime * result
				+ ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result
				+ ((displayName == null) ? 0 : displayName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((mdmindex == null) ? 0 : mdmindex.hashCode());
		result = prime * result
				+ ((productId == null) ? 0 : productId.hashCode());
		result = prime * result
				+ ((rejectionCause == null) ? 0 : rejectionCause.hashCode());
		result = prime * result
				+ ((sentToMdm == null) ? 0 : sentToMdm.hashCode());
		result = prime
				* result
				+ ((processingObjectType == null) ? 0 : processingObjectType
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductRejection other = (ProductRejection) obj;
		if (addedByProductCatalog == null) {
			if (other.addedByProductCatalog != null)
				return false;
		} else if (!addedByProductCatalog.equals(other.addedByProductCatalog))
			return false;
		if (catalogName == null) {
			if (other.catalogName != null)
				return false;
		} else if (!catalogName.equals(other.catalogName))
			return false;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		if (displayName == null) {
			if (other.displayName != null)
				return false;
		} else if (!displayName.equals(other.displayName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mdmindex == null) {
			if (other.mdmindex != null)
				return false;
		} else if (!mdmindex.equals(other.mdmindex))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (rejectionCause == null) {
			if (other.rejectionCause != null)
				return false;
		} else if (!rejectionCause.equals(other.rejectionCause))
			return false;
		if (sentToMdm == null) {
			if (other.sentToMdm != null)
				return false;
		} else if (!sentToMdm.equals(other.sentToMdm))
			return false;
		if (processingObjectType == null) {
			if (other.processingObjectType != null)
				return false;
		} else if (!processingObjectType.equals(other.processingObjectType))
			return false;
		return true;
	}

}
