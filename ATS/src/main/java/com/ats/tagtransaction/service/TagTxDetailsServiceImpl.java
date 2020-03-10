package com.ats.tagtransaction.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.tagtransaction.entity.TagTransactionEntity;
import com.ats.tagtransaction.model.TagTransactionModel;
import com.ats.tagtransaction.repository.TagTransactionRepository;

@Service
public class TagTxDetailsServiceImpl implements TagTxDetailsService {

	@Autowired
	private TagTransactionRepository tagTxRepo;

	@Override
	public List<TagTransactionModel> getTagTxDetails(String tagRegId) {

		List<TagTransactionEntity> listTagTxEntity = tagTxRepo.findByTagRegId(tagRegId);
		List<TagTransactionModel> listTagTxModel = new ArrayList<TagTransactionModel>();

		for (TagTransactionEntity txEntity : listTagTxEntity) {
			TagTransactionModel txModel = new TagTransactionModel();
			BeanUtils.copyProperties(txEntity, txModel);
			listTagTxModel.add(txModel);

		}

		return listTagTxModel;

	}

}
