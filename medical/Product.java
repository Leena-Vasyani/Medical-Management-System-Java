package medical;

public class Product
{
    private String pdtName;
    private int pdtQty;
    float pdtCost;

    public Product(String pdtName, int pdtQty, float pdtCost) {
        this.pdtName = pdtName;
        this.pdtQty = pdtQty;
		this.pdtCost = pdtCost;
    }

    public String getPdtName() {
        return pdtName;
    }

    public void setPdtName(String pdtName) {
        this.pdtName = pdtName;
    }

    public int getPdtQty() {
		return pdtQty;
    }
	
    public void setPdtQty(int pdtQty) {
        this.pdtQty = pdtQty;
    }

	public float getPdtCost() {
		return pdtCost;
    }

	public void setPdtCost(float pdtCost) {
        this.pdtCost = pdtCost;
    }
	
	public void displayPdtInfo() {
        System.out.println("Name: " + pdtName);
        System.out.println("Quantity: " + pdtQty);
		System.out.println("Cost (per entity): Rs. " + pdtCost);
    }
}

	