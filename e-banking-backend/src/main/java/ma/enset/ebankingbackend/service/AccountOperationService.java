package ma.enset.ebankingbackend.service;

import ma.enset.ebankingbackend.dtos.AccountHistoryDTO;
import ma.enset.ebankingbackend.dtos.AccountOperationDTO;
import ma.enset.ebankingbackend.dtos.BankAccountDTO;
import ma.enset.ebankingbackend.enums.OperationType;
import ma.enset.ebankingbackend.exceptions.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountOperationService {

    AccountOperationDTO saveOperation(AccountOperationDTO accountOperation) throws CustumerNotFoundException;


    AccountOperationDTO updateOperation(AccountOperationDTO accountOperation) throws OperationFailedException;

    boolean deleteOperation(long operationId) throws OperationFailedException;

    AccountOperationDTO getOperationById(long id) throws OperationFailedException;

    List<AccountOperationDTO> getAllOperations(int page, int size) throws BankAccountNotFoundException;

    List<AccountOperationDTO> getAccountOperations(String accountId, int page, int size) throws BankAccountNotFoundException;

    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;

    boolean applyOperation(String accountId, double amount, OperationType operationType, String description) throws OperationFailedException, BankAccountNotFoundException, CustumerNotFoundException, BalanceNotSufficientException;

    boolean debitAccount(BankAccountDTO account, double amount, String description) throws BalanceNotSufficientException, BankAccountNotFoundException, CustumerNotFoundException;

    boolean creditAccount(BankAccountDTO account, double amount, String description) throws BankAccountNotFoundException, CustumerNotFoundException;

    boolean transfer(String sourceAccount, String destinationAccount, double amountToTransfer) throws BankAccountNotFoundException, OperationFailedException, CustumerNotFoundException, BalanceNotSufficientException, TransferToTheSameAccountException;
}


