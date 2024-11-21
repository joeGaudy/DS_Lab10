import java.lang.Comparable;
import java.util.function.Consumer;


/**
   This is a smart Node that utilizes generics.
   Note how we ensured that the type T will always be comparable...

 */
public class BSTNode<T extends Comparable<T>>
{

   private T val;
   private BSTNode<T> left;
   private BSTNode<T> right;



   public BSTNode(T val)
   {
      this(val,null,null);
   }
    

   public BSTNode(T val, BSTNode<T> l,BSTNode<T> r)
   {
	   this.val = val;
	   this.left = l;
	   this.right = r;
   }



   /*
     Uses recursion to insert the target into the tree
    */
   public void insert(T target)
   {
	   if(target.compareTo(this.val) > 0 && this.right == null)
	   {
		   this.right = new BSTNode<T>(target);
	   }
	   if(target.compareTo(this.val) < 0 && this.left == null)
	   {
		   this.left = new BSTNode<T>(target);
	   }
	   if(target.compareTo(this.val) > 0)
	   {
		   BSTNode<T> curr = this.right;
		   curr.insert(target);
	   }
	   if(target.compareTo(this.val) < 0)
	   {
		   BSTNode<T> curr = this.left;
		   curr.insert(target);
	   }
   }


   /*
     Uses recursion to retrieved the value target from the tree.  
     Returns null if it can't find the value.
    */
   public T retrieve(T target)
   {
	   if(target.compareTo(this.val) == 0)
	   {
		   return this.val;
	   }
	   if(target.compareTo(this.val) > 0)
	   {
		   BSTNode<T> curr = this.right;
		   if(curr == null)
		   {
			   return null;
		   }else
		   {
			   return curr.retrieve(target);
		   }
	   }
	   if(target.compareTo(this.val) < 0)
	   {
		   BSTNode<T> curr = this.left;
		   if(curr == null)
		   {
			   return null;
		   }else
		   {
			   return curr.retrieve(target);
		   }
	   }
	   return null;
   }


    /**
       If it is present, what level is the node?
       If it is not present, what level would it be placed.
     */
   public int retrieveDepth(T target)
   {
	   if(target.compareTo(this.val) == 0)
	   {
		   return 0;
	   }
	   if(target.compareTo(this.val) > 0 && this.right == null)
	   {
		   return 1;
	   }
	   if(target.compareTo(this.val) < 0 && this.left == null)
	   {
		  return 1;
	   }
	   if(target.compareTo(this.val) > 0)
	   {
		   BSTNode<T> curr = this.right;
		   return 1 + curr.retrieveDepth(target);
	   }
	   if(target.compareTo(this.val) < 0)
	   {
		   BSTNode<T> curr = this.left;
		   return 1 + curr.retrieveDepth(target);
	   }
	   return 0;
   }

   /**
      Uses recursion to return the largest value in the tree
    */
   public T getLargest()
   {
	   if(this.right == null)
	   {
		   return this.val;
	   }else
	   {
		   BSTNode<T> curr = this.right;
		   return curr.getLargest();
	   }
   }

   /**
      Uses recursion to do an inorder traversals.
      consume is part of a strategy pattern, to determine what the
      "Visit" should be.

    */
   public void inOrderTraversal(Consumer<T> consume)
   {
	   if(this.left != null)
	   {
		   this.left.inOrderTraversal(consume);
	   }
	   consume.accept(val);
	   if(this.right != null)
	   {
		   this.right.inOrderTraversal(consume);
	   }
   }


   /**
      returns true if this tree is equal to that tree.
      false otherwise.

      Note: While I must always be non-null.  
            Nothing prevents "that" from being null.
	    
	    This one is long!
    */
   public boolean myEquals(BSTNode<T> that)
   {
	   if (!this.val.equals(that.val))
	   {
		   return false;
	   }
	   if (this.right == null && that.right != null)
	   {
		   return false;
	   }
	   if (this.right != null && that.right == null)
	   {
		   return false;
	   }
	   if (this.left == null && that.left != null)
	   {
		   return false;
	   }
	   if (this.left != null && that.left == null)
	   {
		   return false;
	   }
	   if (this.left != null && !this.left.myEquals(that.left))
	   {
		   return false;
	   }
	   if (this.right != null && !this.right.myEquals(that.right))
	   {
		   return false;
	   }
	  return true;
   }

}
