package com.fidel.dummybank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fidel.dummybank.model.MerchantInfo;
import com.fidel.dummybank.repository.MerchantRepository;

@Service
public class MerchantServiceImpl implements MerchantService {

	@Autowired
	private MerchantRepository merchantRepository;

	public MerchantServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public MerchantInfo findById(int bankCd) {
		Optional<MerchantInfo> mrInfo = merchantRepository.findById(bankCd);
		MerchantInfo info = new MerchantInfo();
		if (mrInfo.isPresent())
			info = mrInfo.get();

		return info;
	}

}
