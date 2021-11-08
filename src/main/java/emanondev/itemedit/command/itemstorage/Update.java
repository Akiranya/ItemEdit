package emanondev.itemedit.command.itemstorage;

import java.util.Collections;
import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import emanondev.itemedit.ItemEdit;
import emanondev.itemedit.Util;
import emanondev.itemedit.UtilsString;
import emanondev.itemedit.command.ItemStorageCommand;
import emanondev.itemedit.command.SubCmd;

public class Update extends SubCmd {

	public Update(ItemStorageCommand cmd) {
		super("update",cmd, true,true);
	}

	@Override
	public void onCmd(CommandSender sender, String[] args) {
		Player p = (Player) sender;
		try {
			if (args.length != 2)
				throw new IllegalArgumentException("Wrong param number");
			if (ItemEdit.get().getPlayerStorage().getItem(p,args[1])!=null)
				ItemEdit.get().getPlayerStorage().setItem(p,args[1],this.getItemInHand(p).clone());
			else
				throw new IllegalArgumentException();
			Util.sendMessage(p, UtilsString.fix(this.getConfString("success"), p, true, "%id%",
					args[1].toLowerCase()));
		} catch (Exception e) {
			onFail(p);
		}
	}

	@Override
	public List<String> complete(CommandSender sender, String[] args) {
		if (!(sender instanceof Player))
			return Collections.emptyList();
		switch (args.length) {
		case 2:
			return Util.complete(args[1], ItemEdit.get().getPlayerStorage().getIds((Player) sender));
		}
		return Collections.emptyList();
	}
}
