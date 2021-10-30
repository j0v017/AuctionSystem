package com.wells.qart.eAuction.service.impl;

import com.wells.qart.eAuction.dto.SellerDto;
import com.wells.qart.eAuction.entity.Seller;
import com.wells.qart.eAuction.exceptions.SellerNotFoundException;
import com.wells.qart.eAuction.repository.SellerRepository;
import com.wells.qart.eAuction.service.SellerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerRepository repository;

	@Override
	public SellerDto registerSeller(SellerDto sellerDto) {
		Seller sellerEntity = new Seller();
		BeanUtils.copyProperties(sellerDto, sellerEntity);
		Seller seller = repository.save(sellerEntity);
		sellerDto.setSellerId(seller.getSellerId());
		return sellerDto;
	}

	@Override
	public SellerDto updateSeller(SellerDto sellerDto) {
		Seller sellerEntity = new Seller();
		BeanUtils.copyProperties(sellerDto, sellerEntity);
		repository.save(sellerEntity);
		return sellerDto;
	}

	@Override
	public Boolean deleteSeller(Long sellerId) {
		SellerDto sellerById =getSellerById(sellerId);
		Seller sellerEntity = new Seller();
		BeanUtils.copyProperties(sellerById, sellerEntity);
		repository.delete(sellerEntity);
		return true;
	}


	@Override
	public SellerDto getSellerById(Long sellerId) {
		Optional<Seller> seller = repository.findById(sellerId);
		if (seller.isPresent()) {
			SellerDto sellerDto = new SellerDto();
			BeanUtils.copyProperties(seller.get(), sellerDto);
			return sellerDto;
		} else {
			throw new SellerNotFoundException("Seller with id " + sellerId + " does not exists");
		}
	}

	@Override
	public SellerDto addProduct(SellerDto sellerDto) {
		Seller seller =new Seller();
		BeanUtils.copyProperties(sellerDto, seller);
		repository.save(seller);
		return sellerDto;
	}

	@Override
	public List<SellerDto> getAllSellers() {
		List<Seller> sellers = repository.findAll();
		List<SellerDto> sellerDtos = new ArrayList<>();
		for (Seller entity : sellers) {
			SellerDto sellerDto = new SellerDto();
			BeanUtils.copyProperties(entity, sellerDto);
			sellerDtos.add(sellerDto);
		}
		return sellerDtos;
	}



}