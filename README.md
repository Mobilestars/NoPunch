# 🏹 NoPunch

A simple **Minecraft Spigot/Paper plugin** that disables the **Punch enchantment** on bows.  
Ideal for PvP or competitive servers where knockback from bows should be removed for fair gameplay.

---

## ⚙️ Features

- 🚫 **Blocks Punch enchantment** from being applied at the enchantment table  
- 🧱 **Prevents combining Punch books** with bows in an anvil  
- ❌ **Cancels anvil results** that contain Punch  
- 💬 Sends a warning message to players when Punch is blocked  
- ⚡ Lightweight and configuration-based — no dependencies required  

---

## 📁 Installation

1. Download the plugin `.jar` file  
2. Place it inside your server’s `plugins/` folder  
3. Start or reload your server  
4. A default `config.yml` will be generated automatically  

---

## ⚙️ Configuration (`config.yml`)

```yaml
# Allow or block the Punch enchantment
allow-punch: false
```

- allow-punch: true → Punch can be applied normally

- allow-punch: false → Punch is completely disabled

## 💬 Example Message

When a player tries to add or use Punch:

§cPunch is disabled!

You can change this message in the code to match your preferred language.

## 🧩 Developer Information

Main plugin class:
de.scholle.noPunch.NoPunch

Event listener:
de.scholle.noPunch.PunchEnchantBlocker

Blocked enchantment:
Enchantment.ARROW_KNOCKBACK (Punch I & II)

## 🧰 Compatibility

- ✅ Works on Spigot, Paper, and Purpur

- 🧱 Tested on Minecraft 1.18+

- ⚙️ Requires Java 17+
