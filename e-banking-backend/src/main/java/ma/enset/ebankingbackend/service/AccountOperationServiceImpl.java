package ma.enset.ebankingbackend.service;

//package ma.enset.ebankingbackend.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.ebankingbackend.dtos.AccountHistoryDTO;
import ma.enset.ebankingbackend.dtos.AccountOperationDTO;
import ma.enset.ebankingbackend.dtos.BankAccountDTO;
import ma.enset.ebankingbackend.entities.AccountOperation;
import ma.enset.ebankingbackend.enums.OperationType;
import ma.enset.ebankingbackend.exceptions.BalanceNotSufficientException;
import ma.enset.ebankingbackend.exceptions.BankAccountNotFoundException;
import ma.enset.ebankingbackend.exceptions.CustumerNotFoundException;
import ma.enset.ebankingbackend.exceptions.OperationFailedException;
import ma.enset.ebankingbackend.mappers.BankAccountMapperImpl;
import ma.enset.ebankingbackend.repositories.AccountOperationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
/*
@Service
@Slf4j
@AllArgsConstructor

public class AccountOperationServiceImp implements AccountOperationService {
    AccountOperationRepository operationRepository;
    BankAccountService bankAccountService;
    BankAccountMapperImpl bankMapper;
    @Override
    public AccountOperationDTO saveOperation(AccountOperationDTO accountOperation) throws CustumerNotFoundException {
        log.info("Saving operation ....");
        if(accountOperation == null) throw new CustumerNotFoundException("Invalid operation [NULL]");
        return bankMapper.fromAccountOperation(operationRepository.save(bankMapper.fromAccountOperationDTO(accountOperation)));
    }

    @Override
    public AccountOperationDTO updateOperation(AccountOperationDTO accountOperation) throws OperationFailedException {
        log.info("Updating operation ....");
        getOperationById(accountOperation.getId());
        return bankMapper.fromAccountOperation(operationRepository.save(bankMapper.fromAccountOperationDTO(accountOperation)));
    }

    @Override
    public boolean deleteOperation(long operationId) throws OperationFailedException {
        log.info("Deleting operation ....");
        AccountOperationDTO operationDTO =  getOperationById(operationId);
        operationRepository.delete(bankMapper.fromAccountOperationDTO(operationDTO));
        return true;
    }

    @Override
    public AccountOperationDTO getOperationById(long id) throws OperationFailedException {
        log.info("Selecting an operation ....");
        return bankMapper.fromAccountOperation(operationRepository.findById(id).orElseThrow(() -> new OperationFailedException(null)));

    }

    @Override
    public List<AccountOperationDTO> getAccountOperations(String accountId, int page, int size) throws AccountNotFoundException {
        BankAccountDTO bankAccountDTO = bankAccountService.getBankAccountById(accountId);
        //List<AccountOperation> accountOperationList = operationRepository.getAccountOperationsByBankAccount(bankMapper.bankAccountFromDTO(bankAccountDTO), PageRequest.of(page, size)).getContent();
        List<AccountOperation> accountOperationList = operationRepository.getAccountOperationsByBankAccountOrderByDateDesc(bankMapper.bankAccountFromDTO(bankAccountDTO), PageRequest.of(page, size)).getContent();
        return accountOperationList.stream().map((accountOperation -> bankMapper.fromAccountOperation(accountOperation))).collect(Collectors.toList());
    }

    @Override
    public List<AccountOperationDTO> getAllOperations(int page, int size) throws AccountNotFoundException {
        List<AccountOperation> accountOperationList = operationRepository.findAll(PageRequest.of(page, size)).getContent();
        return accountOperationList.stream().map((accountOperation -> bankMapper.fromAccountOperation(accountOperation))).collect(Collectors.toList());
    }

    @Override
    public AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws AccountNotFoundException {
        AccountHistoryDTO accountHistoryDTO = new AccountHistoryDTO();
        BankAccountDTO bankAccountDTO = bankAccountService.getBankAccountById(accountId);
        //Page<AccountOperation> accountOperationPage = operationRepository.getAccountOperationsByBankAccount(bankMapper.bankAccountFromDTO(bankAccountDTO), PageRequest.of(page, size));
        Page<AccountOperation> accountOperationPage = operationRepository.getAccountOperationsByBankAccountOrderByDateDesc(bankMapper.fromBankAccountDTO(bankAccountDTO), PageRequest.of(page, size));
        List<AccountOperationDTO>  accountOperationDTOList= accountOperationPage.getContent().stream().map((accountOperation -> bankMapper.fromAccountOperation(accountOperation))).collect(Collectors.toList());

        accountHistoryDTO.setAccountId(bankAccountDTO.getId());
        accountHistoryDTO.setBalance(bankAccountDTO.getBalance());
        accountHistoryDTO.setTotalPages(accountOperationPage.getTotalPages());
        accountHistoryDTO.setPageSize(accountOperationPage.getSize());
        accountHistoryDTO.setCurrentPage(page);
        accountHistoryDTO.setAccountOperationDTOList(accountOperationDTOList);

        return  accountHistoryDTO;
    }

    @Override
    public boolean applyOperation(String accountId, double amount, OperationType operationType, String description) throws OperationFailedException, BankAccountNotFoundException, CustumerNotFoundException, BalanceNotSufficientException {
        return false;
    }

    @Override
    public boolean debitAccount(BankAccountDTO account, double amount, String description) throws BalanceNotSufficientException, BankAccountNotFoundException, CustumerNotFoundException {
        return false;
    }


    @Override
    public boolean applyOperation(String accountId, double amount, OperationType operationType, String description) throws OperationFailedException, AccountNotFoundException, CustomerNotFoundException, BalanceNotSufficientException {
        log.info("Applying an operation....");
        BankAccountDTO account = bankAccountService.getBankAccountById(accountId);

        if(amount <= 0) throw  new OperationFailedException("Operation Failed, amount <= 0 !");
        // pass operation
        if(operationType.equals(OperationType.CREDIT)){
            creditAccount(account, amount, description);
        }
        else if (operationType.equals(OperationType.DEBIT)) {
            debitAccount(account, amount, description);
        }
        return true;
    }



    @Override
    public boolean debitAccount(BankAccountDTO account, double amount, String description) throws BalanceNotSufficientException, AccountNotFoundException, CustomerNotFoundException {
        log.info("Applying a debit....");
        double balance = account.getBalance();
        if(balance < amount) throw new BalanceNotSufficientException("Operation Failed, balance < amount !");

        // create the operation
        AccountOperationDTO accountOperationDTO = new AccountOperationDTO();
        accountOperationDTO.setOperationType(OperationType.DEBIT);
        //accountOperationDTO.setBankAccountDTO(account);
        accountOperationDTO.setDate(new Date());
        accountOperationDTO.setAmount(amount);
        accountOperationDTO.setDescription(description);
        accountOperationDTO.setBankAccountDTO(account);

        // save operation
        saveOperation(bankMapper.dtoFromAccountOperation(bankMapper.accountOperationFromDTO(accountOperationDTO)));
        // update account data

        account.setBalance(balance - amount);
        bankAccountService.updateAccount(account);

        return true;
    }

    @Override
    public boolean creditAccount(BankAccountDTO account, double amount, String description) throws AccountNotFoundException, CustomerNotFoundException {
        log.info("Applying a credit....");

        double balance = account.getBalance();
        // create the operation
        AccountOperationDTO accountOperationDTO = new AccountOperationDTO();
        accountOperationDTO.setOperationType(OperationType.CREDIT);
        //accountOperationDTO.setBankAccountDTO(account);
        accountOperationDTO.setDate(new Date());
        accountOperationDTO.setAmount(amount);
        accountOperationDTO.setDescription(description);
        accountOperationDTO.setBankAccountDTO(account);
        // save operation
        saveOperation(accountOperationDTO);
        // update account data

        account.setBalance(balance + amount);
        //account.getAccountOperationList().add(accountOperation);
        bankAccountService.updateAccount(account);


        return true;
    }

    @Override
    public boolean transfer(String sourceAccount, String destinationAccount, double amountToTransfer) throws AccountNotFoundException, OperationFailedException, CustomerNotFoundException, BalanceNotSufficientException, TransferToTheSameAccountException {
        log.info("Applying a transfer....");

        final  String description = "Transfer operation from ".concat(sourceAccount).concat(" To ").concat("destination");
        if(sourceAccount.equals(destinationAccount)) throw new TransferToTheSameAccountException("Operation failed, trying to transfer from and to the same account !");
        // Making sure that the two are there (Before any operation)
        bankAccountService.getBankAccountById(sourceAccount);
        bankAccountService.getBankAccountById(destinationAccount);

        applyOperation(sourceAccount, amountToTransfer, OperationType.DEBIT, description);
        applyOperation(destinationAccount, amountToTransfer, OperationType.CREDIT, description);

        return false;
    }

}
*/
