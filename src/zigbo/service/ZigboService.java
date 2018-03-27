package zigbo.service;

import java.sql.SQLException;
import java.util.ArrayList;

import zigbo.exception.NotExistException;
import zigbo.model.dao.*;
import zigbo.model.dto.*;

public class ZigboService {

   //// ITEM SERVICE ////
	
   // ���ο� item ����
   public static boolean addItem(ItemDTO item) throws SQLException {
      return ItemDAO.addItem(item);
   }

   // get item
   public static ItemDTO getItem(int itemCode) throws SQLException {
      return ItemDAO.getItem(itemCode);
   }

   // ��� item �˻�
   public static ArrayList<ItemDTO> getAllItem() throws SQLException {
      return ItemDAO.getAllItem();
   }

   // item ����
   public static boolean deleteItem(int itemCode) throws SQLException {
	   return ItemDAO.deleteItem(itemCode);
   }
   
   //// INTEREST SERVICE ////

   // ���ο� ��
   public static boolean addInterest(InterestDTO interest) throws SQLException {
      return InterestDAO.addInterest(interest);
   }

   // Ư�� Selling���� �򰳼� ��ȯ
   public static int getInterestOfSelling(int sellingCode) throws SQLException {
      return InterestDAO.getInterestOfSelling(sellingCode);
   }

   // �� ����
   public static boolean deleteInterest(int memberCode, int sellingCode) throws SQLException {
         return InterestDAO.deleteInterest(memberCode, sellingCode);
   }
   
   //// SELLING SERVICE ////
   
   // ���ο� Selling �߰�
   public static boolean addSelling(SellingDTO selling) throws SQLException {
      return SellingDAO.addSelling(selling);
   }
   
   // Ư�� Selling ��ȯ
   public static SellingDTO getSelling(int sellingCode) throws SQLException {
      return SellingDAO.getSelling(sellingCode);
   }
   
   // ��� Selling �˻�
   public static ArrayList<SellingDTO> getAllSelling() throws SQLException {
      return SellingDAO.getAllSelling();
   }
   
   //��ȸ�� ����
   public static boolean updateSellingViews(int sellingCode) throws SQLException {      
      return SellingDAO.updateSellingViews(sellingCode);
   }
   
   //������� ����
   public static boolean updateSellingProgress(int sellingCode) throws SQLException {      
      return SellingDAO.updateSellingProgress(sellingCode);
   }
   
   //��ȸ�� ���� �� Sellings ��ȯ
   public static ArrayList<SellingDTO> getMostViews() throws SQLException {
      return SellingDAO.getMostViews();
   }
   
   // �ֽż� Sellings ��ȯ
   public static ArrayList<SellingDTO> getMostRecent() throws SQLException {
      return SellingDAO.getMostRecent();
   }
   
   // ��� Sellings ��ȯ
   public static ArrayList<SellingDTO> getMostInterest() throws SQLException {
      return SellingDAO.getMostInterest();
   }
   
   public static ArrayList<SellingMemberDTO> getAllSellingMember() throws SQLException{ 
	   return SellingDAO.getAllSellingMember();
   }
   
   ////PAYMENT SERVICE ////
   
   // ���� �߰�
   public static boolean addPayment(PaymentDTO payment) throws SQLException {
      return PaymentDAO.addPayment(payment);
   }
   
   // Ư�� ���� Ž��
   public static PaymentDTO getPayment(int paymentCode) throws SQLException {
      return PaymentDAO.getPayment(paymentCode);
   }
   
   // ȸ���� ���� ���� ����
   public static ArrayList<PaymentDTO> getPaymentofMember(int memberCode) throws SQLException {
      return PaymentDAO.getPaymentofMember(memberCode);
   }
   
   ////MEMBER SERVICE ////
   public static String getEmailByMemberCode(int memberCode) throws SQLException{
	   return MemberDAO.getEmailByMemberCode(memberCode);
   }
   
   public static int getCountByEmail(String email) throws SQLException{
	   return MemberDAO.getCountByEmail(email);
   }
   
   public static MemberDTO getMemberByEmail(String email) throws SQLException{
	   return MemberDAO.getMemberByEmail(email);
   }
   
   public static MemberDTO getMemberByMemberCode(int memberCode) throws SQLException {
	   return MemberDAO.getMemberByMemberCode(memberCode);
   }
   
	public static boolean addMember(MemberDTO member) throws SQLException {
		return MemberDAO.addMember(member);
	}

	public static MemberDTO getMember(String email, String password) throws NotExistException, SQLException {
		return MemberDAO.getMember(email,password);
	}

	public static boolean updateMember(int memberCode, String password, String phone, String address, String account) throws SQLException, NotExistException {
		return MemberDAO.updateMember(memberCode, password, phone, address, account);
	}

	public static boolean deleteMember(int memberCode) throws SQLException {
			return MemberDAO.deleteMember(memberCode);
	}

	public static ArrayList<SellingDTO> getSellingofMember(int MemberCode) throws SQLException {
		return SellingDAO.getSellingofMember(MemberCode);
	}
	
	////REQUEST SERVICE ////

	public static boolean addRequest(RequestDTO request) throws SQLException {
		return RequestDAO.addRequest(request);
	}

	public static RequestDTO getRequest(int requestCode) throws SQLException {
		return RequestDAO.getRequest(requestCode);
	}

	// getAllRequest()
	public static ArrayList<RequestDTO> getAllRequest() throws SQLException {
		return RequestDAO.getAllRequest();
	}
	
	public static ArrayList<RequestMemberDTO> getAllRequestMember() throws SQLException {
		return RequestDAO.getAllRequestMember();
	}

	public static boolean updateRequestViews(int requestCode) throws SQLException {
			return RequestDAO.updateRequestViews(requestCode);
	}
	
	public static boolean updateRequestProgressToP(int requestCode) throws SQLException {
		return RequestDAO.updateRequestProgressToP(requestCode);
	}
	
	public static boolean updateRequestProgressToD(int requestCode) throws SQLException {
		return RequestDAO.updateRequestProgressToD(requestCode);
	}
	
	public static ArrayList<RequestDTO> getRequestofMember(int memberCode) throws SQLException {
		return RequestDAO.getRequestofMember(memberCode);
	}
	
	public static ArrayList<RequestDTO> getMostRecentRequest() throws SQLException {
		return RequestDAO.getMostRecentRequest();
	}
	
	////APPLY SERVICE ////
	 public static boolean addApply(ApplyDTO apply) throws SQLException {
		 return ApplyDAO.addApply(apply);
	 }
	 
	 public static ApplyDTO getApply(int ApplyCode) throws SQLException {
		 return ApplyDAO.getApply(ApplyCode);
	 }
	 
	 public static ArrayList<ApplyDTO> getAllApply() throws SQLException {
		 return ApplyDAO.getAllApply();
	 }
	 
	 public static boolean deleteApply(int applyCode) throws SQLException {
		 return ApplyDAO.deleteApply(applyCode);
	 }
	
	 public static ArrayList<ApplyDTO> getApplyofMember(int memberCode) throws SQLException {
		 return ApplyDAO.getApplyofMember(memberCode);
	 }
	 
	 public static ArrayList<ApplyRequestDTO> getApplyMemberRequest(int memberCode) throws SQLException {
		 return ApplyDAO.getApplyMemberRequest(memberCode);
	 }
	 
	 public static int getItemCodebyRequest(int requestCode) throws SQLException {
		 return RequestDAO.getItemCodebyRequest(requestCode);
	 }
	 
	 public static ApplyDTO getApplyByRequest(int requestCode) throws SQLException{
		 return ApplyDAO.getApplyByRequest(requestCode);
	 }
	 
	 public static boolean addRequestPayment(RequestPaymentDTO payment) throws SQLException {
		 return PaymentDAO.addRequestPayment(payment);
	 }
	 
	 public static ArrayList<RequestPaymentDTO> getRequestPayment(int memberCode) throws SQLException{
		 return PaymentDAO.getRequestPayment(memberCode);
	 }
}
