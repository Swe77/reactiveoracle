package org.acme.audit.resource;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.audit.entity.Audit;
import org.jboss.logging.Logger;

import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.core.eventbus.EventBus;

@ApplicationScoped
@Path("/audit")
public class AuditResource {

	private static final Logger LOG = Logger.getLogger(AuditResource.class);

	@Inject
	EventBus bus;

	@POST
	@Path("/v1/audit-trail")
	@Produces(MediaType.APPLICATION_JSON)
	public Uni<Void> createTrail() {

		Audit audit = new Audit();
		audit.setTransactionName("ACCOUNT BALANCE");
		audit.setTransactionUrl("http://localhost:...");

		bus.requestAndForget("AUDIT_BUS", audit);

		return Uni.createFrom().nullItem();
	}
}
