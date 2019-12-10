package com.scoperetail.order.persistence.custom;

import java.util.List;

import com.scoperetail.commons.orderLine.search.dto.request.OrderDetailsFinderRequest;
import com.scoperetail.order.persistence.query.mapper.OrderedLineDetailsDto;

public interface SubAlsoOrderedQtyFinder {

  List<OrderedLineDetailsDto> getOriginalOrderedQty(
      final List<OrderDetailsFinderRequest> orderDetailsFinderList);
}
