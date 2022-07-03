package org.acme.audit.service;

import java.util.concurrent.atomic.AtomicLong;

import javax.enterprise.context.ApplicationScoped;

import org.acme.audit.entity.Audit;
import org.jboss.logging.Logger;

import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional;
import io.quarkus.vertx.ConsumeEvent;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
public class AuditService {
	
	Logger log = Logger.getLogger(AuditService.class);	
	private static AtomicLong counter = new AtomicLong();
	
	@ConsumeEvent("AUDIT_BUS")
	@ReactiveTransactional
	public Uni<Void> saveTrail(Audit audit) {
		log.info("### [TRAIL RECORDING] COUNTER: " + counter.incrementAndGet());
		return Audit.persist(audit);				
	}
}
