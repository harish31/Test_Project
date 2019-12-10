package com.scoperetail.order.persistence.repository;

import com.scoperetail.order.persistence.SupplierOrderGenerator;
import com.scoperetail.order.persistence.entity.OrderCustomer;
import com.scoperetail.order.persistence.entity.OrderLine;
import com.scoperetail.order.persistence.entity.SupplierOrder;
import com.scoperetail.order.persistence.entity.SupplierOrderEnriched;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
// @SpringBootTest(classes = SupplierOrderPersistenceApplication.class)
@DataJpaTest
@Slf4j
class SupplierOrderRepositoryTest {
  @Autowired private SupplierOrderRepository supplierOrderRepository;

  @Autowired private SupplierOrderEnrichedRepository supplierOrderEnrichedRepository;

  @Autowired private OrderCustomerRepository orderCustomerRepository;

  @Test
  void createSupplierOrder() {
    SupplierOrder supplierOrder = SupplierOrderGenerator.INSTANCE.createSupplierOrder(2, true);
    SupplierOrder savedSupplierOrder = supplierOrderRepository.save(supplierOrder);
    assertNotNull(savedSupplierOrder.getOrderId());
    assertNotNull(savedSupplierOrder.getCreateTs());
    assertNotNull(savedSupplierOrder.getCreatedBy());
  }

  @Test
  void updateExistingSupplierOrderWithOrderLineEnrichedData() {
    SupplierOrder supplierOrder = SupplierOrderGenerator.INSTANCE.createSupplierOrder(1, true);
    SupplierOrder savedSupplierOrder = supplierOrderRepository.save(supplierOrder);
    assertNotNull(savedSupplierOrder.getOrderId());
    assertNotNull(savedSupplierOrder.getCreateTs());
    assertNotNull(savedSupplierOrder.getCreatedBy());

    OrderLine line = savedSupplierOrder.getOrderLines().iterator().next();
    assertNotNull(line.getOrderLineEnriched());

    // Update Orderline Enriched
    line.getOrderLineEnriched().setSupplierProductId("123");
    //    line.setOrderLineEnriched(orderLineEnriched);
    //    orderLineEnriched.setOrderLine(line);

    supplierOrderRepository.save(savedSupplierOrder);
  }

  @Test
  void createSupplierOrderEnrich() {
    SupplierOrder supplierOrder = SupplierOrderGenerator.INSTANCE.createSupplierOrder(2, true);

    SupplierOrderEnriched supplierOrderEnriched =
        SupplierOrderEnriched.builder()
            .totalItemQty(12)
            .totalItemWgt(BigDecimal.ONE)
            .totalPalletQty(BigDecimal.ONE)
            .totalCubeVolume(BigDecimal.ONE)
            .scheduledCutoffDate(LocalDate.now())
            .scheduledCutoffTime(LocalTime.now())
            .scheduledReleaseDate(LocalDate.now())
            .scheduledReleaseTime(LocalTime.now())
            .scheduledDeliveryDate(LocalDate.now())
            .scheduledProcessDate(LocalDate.now())
            .restrictedOrderDate(LocalDate.now())
            .shelfAvailabilityDate(LocalDate.now())
            .stopId(12)
            .routeId(12)
            .routeCode("acbd")
            .poRefNbr("1234")
            .transferTypeCd("M2")
            .comment("comment")
            .supplierOrder(supplierOrder)
            .build();
    supplierOrder.setSupplierOrderEnriched(supplierOrderEnriched);

    OrderCustomer orderCustomer = OrderCustomer.builder().supplierOrder(supplierOrder).build();
    supplierOrder.setOrderCustomer(orderCustomer);

    supplierOrderRepository.save(supplierOrder);

    assertNotNull(supplierOrder.getOrderId());

    final SupplierOrder actualSupplierOrder =
        supplierOrderRepository.findById(supplierOrder.getOrderId()).get();
    final SupplierOrderEnriched actualSupplierOrderEnriched =
        supplierOrderEnrichedRepository.findById(supplierOrder.getOrderId()).get();
    final OrderCustomer actualOrderCustomer =
        orderCustomerRepository.findById(supplierOrder.getOrderId()).get();

    assertNotNull(actualSupplierOrder);
    assertEquals(actualSupplierOrder.getOrderId(), supplierOrder.getOrderId());

    assertNotNull(actualSupplierOrderEnriched);
    assertEquals(actualSupplierOrderEnriched.getOrderId(), supplierOrder.getOrderId());

    assertNotNull(actualOrderCustomer);
    assertEquals(actualOrderCustomer.getOrderId(), supplierOrder.getOrderId());
  }
}
