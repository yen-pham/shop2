package vn.edu.leading.shop.services;

import org.springframework.stereotype.Service;
import vn.edu.leading.shop.models.SupplierModel;
import vn.edu.leading.shop.repositories.SupplierRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServicelmpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierServicelmpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<SupplierModel> findAll() {
        return supplierRepository.findAll();
    }

    @Override
    public List<SupplierModel> search(String term) {
        return supplierRepository.findBySupplierNameContaining(term);
    }

    @Override
    public Optional<SupplierModel> findById(Long id) {
        return supplierRepository.findById(id);
    }

    @Override
    public boolean update(SupplierModel supplier) {
        SupplierModel supplierModel = supplierRepository.findById(supplier.getId()).orElse(null);
        if (supplierModel == null)
            return false;
        supplierRepository.save(supplier);
        return true;
    }

    @Override
    public void save(SupplierModel supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public boolean delete(Long id) {
        SupplierModel supplierModel = supplierRepository.findById(id).orElse(null);
        if (supplierModel == null)
            return false;
        supplierRepository.delete(supplierModel);
        return true;
    }
}
